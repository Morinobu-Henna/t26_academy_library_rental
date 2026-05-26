package jp.co.metateam.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jp.co.metateam.library.model.RentalManage;
import jp.co.metateam.library.model.RentalManageDto;
import jp.co.metateam.library.service.RentalManageService;
import jp.co.metateam.library.service.AccountService;
import jp.co.metateam.library.service.StockService;
import jp.co.metateam.library.values.RentalStatus;
import lombok.extern.log4j.Log4j2;
import java.sql.Timestamp;

/**
 * 貸出管理関連クラスß
 */
@Log4j2
@Controller
public class RentalManageController {

    /**
     * 貸出一覧画面初期表示
     * 
     * @param model
     * @return
     */

    private final RentalManageService rentalManageService;
    private final AccountService accountService;
    private final StockService stockService;

    @Autowired
    public RentalManageController(
            RentalManageService rentalManageService,
            AccountService accountService,
            StockService stockService) {
        this.rentalManageService = rentalManageService;
        this.accountService = accountService;
        this.stockService = stockService;
    }

    @GetMapping("/rental/index")
    public String index(Model model) {
        // 貸出管理テーブルから全件取得

        // 貸出一覧画面に渡すデータをmodelに追加

        // 貸出一覧画面に遷移
        return "/rental/index";
    }

    @GetMapping("/rental/add")
    public String add(Model model) {

        model.addAttribute("rentalManageDto", new RentalManageDto());
        model.addAttribute("title", "貸出登録");
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("stockList", stockService.findAll());
        model.addAttribute("rentalStatus", RentalStatus.values());

        return "/rental/add";
    }

    @PostMapping("/rental/add")
    public String save(
            @Valid @ModelAttribute RentalManageDto rentalManageDto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("rentalManageDto", rentalManageDto);
            model.addAttribute("title", "貸出登録");
            model.addAttribute("accounts", accountService.findAll());
            model.addAttribute("stockList", stockService.findAll());
            model.addAttribute("rentalStatus", RentalStatus.values());
            return "/rental/add";
        }

        // 保存処理
        RentalManage rentalManage = new RentalManage();

        rentalManage.setEmployeeId(rentalManageDto.getEmployeeId());

        rentalManage.setExpectedRentalOn(
                Timestamp.valueOf(
                        rentalManageDto.getExpectedRentalOn().atStartOfDay()));

        rentalManage.setExpectedReturnOn(
                Timestamp.valueOf(
                        rentalManageDto.getExpectedReturnOn().atStartOfDay()));

        rentalManage.setStockId(rentalManageDto.getStockId());

        rentalManage.setStatus(
                String.valueOf(rentalManageDto.getStatus()));

        Timestamp now = new Timestamp(System.currentTimeMillis());

        rentalManage.setCreatedAt(now);
        rentalManage.setUpdatedAt(now);

        rentalManageService.save(rentalManage);

        // 一覧画面へ
        return "/rental/index";
    }
}
