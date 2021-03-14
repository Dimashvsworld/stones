package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.enteties.Precious;
import com.company.repositories.PreciousRepository;
import com.company.repositories.interfaces.IPreciousRepository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IDB db = new PostgresDB();
        IPreciousRepository preciousRepository = new PreciousRepository(db);

        StonesFrontEnd app = new StonesFrontEnd(preciousRepository);
        app.start() ;
    }
}
