package me.weekbelt.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.weekbelt.board.dto.BoardDTO;
import me.weekbelt.board.dto.PageRequestDTO;
import me.weekbelt.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list............" + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
        log.info("dto....." + dto);
        Long bno = boardService.register(dto);
        log.info("BNO: " + bno);
        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long bno, Model model) {

        log.info("bno: " + bno);

        BoardDTO boardDTO = boardService.get(bno);

        log.info(boardDTO.toString());

        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/remove")
    public String remove(long bno, RedirectAttributes redirectAttributes) {
        log.info("bno: " + bno);

        boardService.removeWithReplies(bno);

        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes) {
        log.info("post modify...........................................");
        log.info("dto: " + dto);

        boardService.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());

        redirectAttributes.addAttribute("bno", dto.getBno());
        return "redirect:/board/read";
    }

}
