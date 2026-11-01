import json
import pathlib
import struct
import zlib

root = pathlib.Path(__file__).resolve().parents[1]
count = 0
for catalog in (root / 'data').rglob('Contents.json'):
    for image in json.loads(catalog.read_text()) .get('images', []):
        if 'filename' not in image:
            continue
        path = catalog.parent / image['filename']
        assert path.name in {p.name for p in path.parent.iterdir()}, f'Missing/case mismatch: {path}'
        data = path.read_bytes()
        assert data[:8] == b'\x89PNG\r\n\x1a\n', f'Not PNG: {path}'
        if 'size' in image:
            size = [round(float(v) * float(image['scale'][:-1])) for v in image['size'].split('x')]
            assert list(struct.unpack('>II', data[16:24])) == size, f'Wrong dimensions: {path}'
        offset = 8
        while offset < len(data):
            length = struct.unpack('>I', data[offset:offset + 4])[0]
            chunk = data[offset + 4:offset + 8 + length]
            crc = struct.unpack('>I', data[offset + 8 + length:offset + 12 + length])[0]
            assert zlib.crc32(chunk) & 0xffffffff == crc, f'PNG CRC error: {path}'
            offset += length + 12
        count += 1
print(f'PASS: {count} catalog images, filenames, dimensions and PNG checksums')
