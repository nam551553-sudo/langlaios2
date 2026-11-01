# Làng Lá iOS

Client Java/libGDX, build bằng RoboVM trên macOS. Mã nguồn dùng chung nằm ở `src`; launcher iOS ở `ios/src`; tài nguyên đóng gói ở `resource`, `music`, `sound`.

## Tải IPA

Mở tab **Actions → Build iOS IPA → lần chạy thành công → Artifacts → LangLa-iOS-unsigned**. Giải nén artifact để lấy `.ipa`. Đây là IPA arm64 **chưa ký**, cần ký lại bằng công cụ sideload và Apple ID/chứng chỉ của bạn trước khi cài lên iPhone. Không phải bản đã ký để phát hành App Store.

Workflow chạy khi push lên `main`, hoặc bấm **Run workflow** trong Actions. Dùng macOS 15, Xcode 16.4, JDK 17 và RoboVM 2.3.26.

Build thủ công trên Mac:

```bash
chmod +x gradlew
./gradlew -PwithIos -PiosOnly -Probovm.iosSkipSigning=true -Probovm.archs=arm64 :ios:createIPA
```

## Sửa bộ tải ảnh

- Giới hạn số lần tải lại; không treo khi không tải được manifest.
- Loại phản hồi HTTP lỗi, rỗng hoặc chưa đủ Content-Length; không nối nhầm dữ liệu khi tải lại, không mất dữ liệu sau 60 MB.
- Kiểm tra hàng đợi trước khi chờ tín hiệu, tránh bỏ lỡ tác vụ tải ảnh.
- Icon khởi động thiếu/hỏng được tải bất đồng bộ; ảnh thất bại có thể thử lại sau 30 giây.
- Kiểm tra giải mã trước khi ghi cache ảnh tải lẻ.
- Tiền tố giải nén thuộc từng archive, tránh lẫn icon giữa các luồng; archive hỏng không được đánh dấu cài thành công.
- iOS đóng gói tài nguyên trực tiếp, không cần Android SDK.

`ios/tests/AssetHttpTest.java` kiểm tra file 61 MB, phản hồi bị cắt, HTTP 404 và giới hạn retry. Kiểm tra Java/IPA không thay thế thử giao diện và đăng nhập trên iPhone thật. Tài nguyên tải thêm phụ thuộc hosting trong `src/beatdz/NetworkConfig.java`.
