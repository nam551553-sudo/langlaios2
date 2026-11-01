# Làng Lá Kage iOS

Client Java/libGDX, build bằng RoboVM trên macOS. Mã nguồn dùng chung nằm ở `src`; launcher iOS ở `ios/src`; tài nguyên đóng gói ở `resource`, `music`, `sound`.

Nhà phát triển hiển thị: **Krin**. iOS dùng zoom 3 cho giao diện và toàn bộ đường dẫn tải tài nguyên, kể cả khi đã có cấu hình độ phân giải cũ. Lời chào: “Chào Mừng Bạn Tới Làng Lá Kage Chúc Bạn Chơi Game Vui Vẽ Mob By-kirin”. Bản sửa khởi động hiển thị `build 4` trên màn hình tải.

Server mặc định: `160.250.128.28`; web dữ liệu/ảnh/manifest/danh sách server: `http://160.250.128.28/`. Giữ nguyên các cổng kết nối hiện có.

## Tải IPA

Mở tab **Actions → Build iOS IPA → lần chạy thành công → Artifacts → Lang-La-Kage-iOS-unsigned**. Giải nén artifact để lấy `Làng Lá Kage.ipa`. Đây là IPA arm64 **chưa ký**, cần ký lại bằng công cụ sideload và Apple ID/chứng chỉ của bạn trước khi cài lên iPhone. Không phải bản đã ký để phát hành App Store.

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

## Cải trang new1–23 / langlaz

Client nhận item ID `1200–1222`, ngoại hình `500–522` và dữ liệu khung qua game server (gói `-126`), rồi tải ảnh `iconChar`/`iconClient` từ `http://160.250.128.28/img/zoom3/`. SQL được game server đọc; không đóng tài khoản/mật khẩu database vào ứng dụng.

`:ios:verifyIosContent` đối chiếu giao thức với fixture công khai lấy từ `new1-23.sql`: 23 bộ × 28 khung nguồn, ánh xạ 33 tư thế, xử lý gói lặp và zoom 3 trên bốn kích thước màn hình. File trong `ios/tests/fixtures` chỉ chứa metadata cải trang, không chứa dữ liệu tài khoản. VPS cần có các item/khung tương ứng trong `langlaz` và server gửi gói `-126`; kiểm tra client không thay thế việc đăng nhập/mặc cải trang trên thiết bị thật.

## Khởi động iOS (build 4)

Metadata đăng nhập và 98 ảnh UI tối thiểu được đóng kèm IPA. Màn hình đăng nhập không chờ Google/Facebook, danh sách server HTTP hoặc tải hết ZIP ảnh cải trang. Cache metadata hỏng được khôi phục từ bản đóng kèm; parser chỉ thử khôi phục một lần, báo lỗi rõ ràng nếu vẫn không đọc được. Có địa chỉ server dự phòng trước khi dựng form; danh sách web được cập nhật sau khi form xuất hiện. Ảnh map/cải trang tiếp tục dùng hàng đợi web/cache.

`:ios:verifyIosStartup` chạy luồng thật từ `CheckVersionScreen` sang `LoginPCScreen` bằng native Pixmap và GL giả lập, với web cố ý không truy cập được: kiểm tra khởi động mới, mở lại, ô tài khoản/mật khẩu và cache metadata hỏng. Đây là kiểm tra lifecycle/khởi tạo widget, không phải thử đăng nhập tài khoản thật trên iPhone.
