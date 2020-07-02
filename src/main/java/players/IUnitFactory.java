package players;

import exceptions.NotEnoughCoinsException;

//abstract factory
public  interface IUnitFactory {
    IUnit createUnit(int maxPrice) throws NotEnoughCoinsException;

}
