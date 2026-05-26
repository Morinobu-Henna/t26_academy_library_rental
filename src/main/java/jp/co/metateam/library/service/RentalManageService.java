package jp.co.metateam.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Timestamp;

import java.util.List;

import jp.co.metateam.library.model.RentalManage;
import jp.co.metateam.library.repository.RentalManageRepository;

@Service
public class RentalManageService {

    @Autowired
    private RentalManageRepository repository;

    public List<RentalManage> findAll() {
        return repository.findAll();
    }

    public void validateRental(Timestamp expectedRentalOn, String status) {

        // Date → LocalDateに変換
        LocalDate rentalDate = expectedRentalOn
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate today = LocalDate.now();

        // 未来日付チェック
        boolean isFuture = rentalDate.isAfter(today);

        // ステータスチェック（0:貸出待ち以外想定）
        boolean isNotWaiting = !"0".equals(status);

        // 条件一致時エラー
        if (isFuture && isNotWaiting) {
            throw new IllegalArgumentException(
                "未来日付では「貸出待ち」を選択してください"
            );
        }
    }

    public void validateRentalStatus(Timestamp expectedRentalOn,String status) {

        // Timestamp → LocalDate変換
        LocalDate rentalDate = expectedRentalOn
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // 今日の日付
        LocalDate today = LocalDate.now();

        // 貸出予定日が過去日付か
        boolean isPastDate = rentalDate.isBefore(today);

        // 「貸出中(1)」以外か
        boolean isNotRentaledStatus = !"1".equals(status);

        // 条件一致でエラー
        if (isPastDate && isNotRentaledStatus) {
            throw new IllegalArgumentException(
                "過去日付では「貸出中」を選択してください"
            );
        }
    }
    
    public void save(RentalManage rentalManage) {

    // 登録
    repository.save(rentalManage);
}

}

