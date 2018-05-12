package am.ak.journal.springbootjournal.web;

import am.ak.journal.springbootjournal.domain.Journal;
import am.ak.journal.springbootjournal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournal() {
        return journalRepository.findAll();
    }

    @RequestMapping("/")
    private String index(Model model) {
        model.addAttribute("journal", journalRepository.findAll());
        return "index";
    }
}
