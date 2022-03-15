package repositories;

import models.Status;

public interface StatusDAO {
    Status getStatusById(Integer statusId);
    void changeStatus(Integer statusId);
}
