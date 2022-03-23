import controllers.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import models.Reimbursement;
import models.User;
import repositories.*;
import services.ReimbursementServices;
import services.UserServices;

public class MainDrive {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);

        UserController userController = new UserController();
        ReimbursementController reimbursementController = new ReimbursementController();
        TypeController typeController = new TypeController();
        StatusController statusController = new StatusController();
        RoleController roleController = new RoleController();


        // user endpoints
        app.post("/login", userController::login);
        app.post("/register", userController::register);

        //reimbursement endpoints
        app.get("/reimbursement", reimbursementController::displayReimbursementForUser);
        app.post("/reimbursement", reimbursementController::createReimbursement);
        app.patch("/approved/{reimbursementId}", reimbursementController::updateStatusApproved);
        app.patch("/denied/{reimbursementId}", reimbursementController::updateStatusDenied);

        //type endpoints
        app.get("/type", typeController::getTypeById);

        //status endpoints
        app.get("/status", statusController::getStatusById);
        app.patch("/status/{statusId}", statusController::changeStatusById);

        //role endpoints
        app.get("/role", roleController::getRoleById);

    }
}
