package edu.zxy.apple.dao;

public interface BaseDao<T>
{
    public void add(T t);

    public void delete(T t);

    public void update(T t);

    public T get(Integer id);

}
