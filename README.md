# Làng Lá iOS

Client Java/libGDX, build bằng RoboVM trên macOS. Mã nguồn dùng chung nằm ở `src`; launcher iOS ở `ios/src`; tài nguyên đóng gói ở `resource`, `music`, `sound`.

## Tải IPA

Mở tab **Actions → Build iOS IPA → lần chạy thành công → Artifacts → LangLa-iOS-unsigned**. Giải nén artifact để lấy `.ipa`. Đây là IPA arm64 **chưa ký**, cần ký lại bằng công cụ sideload và Apple ID/chứng chỉ của bạn trước khi cài lên iPhone. Không phải bản đã ký để phát hành App Store.

Workflow chạy khi push lên `main`, hoặc bấm **Run workflow** trong Actions. Dùng macOS 15, Xcode mặc định trên runner, JDK 17 và RoboVM 2.3.26.

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
- Sửa tên file icon bị thừa `.png` và 9 icon sai kích thước; kiểm tra 21 ảnh trong asset catalog trước khi build.
- Đọc stream đầy đủ dù dữ liệu trả theo từng phần; dữ liệu nén bị cắt không còn gây vòng lặp vô hạn.

`ios/tests/AssetHttpTest.java` kiểm tra file 61 MB, phản hồi bị cắt, HTTP 404 và giới hạn retry. Kiểm tra Java/IPA không thay thế thử giao diện và đăng nhập trên iPhone thật. Tài nguyên tải thêm phụ thuộc hosting trong `src/beatdz/NetworkConfig.java`.

Kiểm tra hosting ngày 01/11/2026: 17 URL trong manifest trả HTTP 200 với dung lượng đúng; giải nén 16 ZIP và giải mã thành công 3.616 ảnh ở 4 mức zoom. Công cụ kiểm tra: `ios/tests/AssetHostingAudit.java`. `:ios:verifyAssetStreams` kiểm tra đọc từng byte, stream không báo độ dài và dữ liệu nén bị cắt.
