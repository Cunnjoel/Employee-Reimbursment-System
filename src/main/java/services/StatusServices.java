package services;

import models.Status;
import repositories.StatusDAO;
import repositories.StatusDAOImlp;

public class StatusServices {
    private StatusDAO statusDAO;

    public StatusServices(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    public StatusServices() {
        this.statusDAO = new StatusDAOImlp();
    }

    public Status getStatusById(Integer statusId) {
        return this.statusDAO.getStatusById(statusId);
    }

    public void changeStatusById(Integer statusId) { this.statusDAO.changeStatus(statusId); }
}