import controllers.*;
import io.javalin.Javalin;
import models.Reimbursement;
import repositories.*;
import services.ReimbursementServices;
import services.StatusServices;
import services.TypeServices;
import services.UserServices;

public class MainDrive {
    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableCorsForOrigin("");
        }).start(9000);

        UserController userController = new UserController();
        ReimbursementController reimbursementController = new ReimbursementController();
        TypeController typeController = new TypeController();
        StatusController statusController = new StatusController();
        RoleController roleController = new RoleController();


        // user endpoints
        app.post("/login", userController::login);

        //reimbursement endpoints
        app.get("/reimbursement", reimbursementController::displayReimbursementForUser);
        app.post("/reimbursement", reimbursementController::createReimbursement);

        //type endpoints
        app.get("/type", typeController::getTypeById);

        //status endpoints
        app.get("/status", statusController::getStatusById);
        app.patch("/status/{statusId}", statusController::changeStatusById);

        //role endpoints
        app.get("/role", roleController::getRoleById);
    }
}
