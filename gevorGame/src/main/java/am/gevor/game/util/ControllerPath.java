package am.gevor.game.util;

/**
 * Created by karlen on 5/27/16.
 */
public interface ControllerPath {

    String LOGIN        = "/login";

    String LOGOUT       = "/logout";

    String CATEGORY     = "/category";

    String SUB_CATEGORY = "/subCategory";

    String LEVEL        = "/level";

    String DELETE       = "/delete";

    String ID           = "/{id}";

    String DELETE_BY_ID = DELETE + "/{subCategoryId}";
}
