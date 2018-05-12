package am.gevor.game.controller;

import am.gevor.game.data.converter.Converter;
import am.gevor.game.data.model.Level;
import am.gevor.game.data.mongo.LevelRepository;
import am.gevor.game.data.mvc.model.LevelForm;
import am.gevor.game.util.ControllerPath;
import am.gevor.game.util.IdProvider;
import com.mongodb.DB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by karlen on 5/29/16.
 */
@Controller
@RequestMapping(value = ControllerPath.LEVEL + ControllerPath.ID)
public class LevelController {

    private static final Logger logger = LoggerFactory.getLogger(LevelController.class);

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @RequestMapping(method = RequestMethod.GET)
    public String levelView(LevelForm levelForm, @PathVariable String id, Model model) {
        try {
            List<Level> levels = levelRepository.findByCategoryId(id);
            model.addAttribute("levels", levels);
            model.addAttribute("categoryId", id);
            return "level-view";
        } catch (Exception e) {
            logger.error("Level view error", e);
            return "error/error";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addLevel(@Valid LevelForm levelForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            try {
                List<Level> levels = levelRepository.findByCategoryId(levelForm.getCategoryId());
                model.addAttribute("levels", levels);
                model.addAttribute("categoryId", levelForm.getCategoryId());
                return "level-view";
            } catch (Exception e) {
                logger.error("Level view error", e);
                return "error/error";
            }
        }
        Converter<Level, LevelForm> converter = (from) -> {
            Level level = new Level();
            level.setCategoryId(from.getCategoryId());
            level.setColumnCount(from.getColumnCount());
            level.setLevelNumber(from.getLevelNumber());
            level.setRowCount(from.getRowCount());
            level.setWinMinStep(from.getWinMinStep());
            return level;
        };
        try {
            DB newDB = mongoDbFactory.getDb(dbName);
            String id = IdProvider.getNextId(newDB, "level");
            Level level = converter.convert(levelForm);
            level.setId(id);
            level.setCreationDate(new Date());
            levelRepository.save(level);
            return "redirect:" + ControllerPath.LEVEL + "/" + level.getCategoryId();
        } catch (Exception e) {
            logger.error("Add Level error", e);
            return "error/error";
        }
    }
}
