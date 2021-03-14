package com.company.repositories.interfaces;

import com.company.enteties.Precious;

import java.util.List;

public interface IPreciousRepository
{
    boolean createPrecious(Precious precious);
    Precious getPrecious(int id);
    List<Precious> getAllPrecious();
}
