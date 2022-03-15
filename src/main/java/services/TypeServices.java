package services;

import models.Type;
import repositories.TypeDAO;
import repositories.TypeDAOImpl;

public class TypeServices {
    private TypeDAO typeDAO;

    public TypeServices(TypeDAO typeDAO){ this.typeDAO = typeDAO; }

    public TypeServices(){ this.typeDAO = new TypeDAOImpl(); }

    public Type getTypeById(Integer typeId) { return this.typeDAO.getTypebById(typeId); }
}
