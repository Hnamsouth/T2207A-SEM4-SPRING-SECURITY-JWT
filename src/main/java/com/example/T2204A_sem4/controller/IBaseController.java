package com.example.T2204A_sem4.controller;

import java.util.List;

public interface IBaseController<S> {
    List<S> get();
    S create(S s);
    S update(S s);
    S update(S s,Long e);
    boolean delete(Long e);
    <K> S find(K id);
    List<S> search(String e);

}
