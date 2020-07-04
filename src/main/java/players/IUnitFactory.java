package players;

import exceptions.NotEnoughCoinsException;

//abstract factory
public  interface IUnitFactory {
    BaseUnit createUnit(int maxPrice) throws NotEnoughCoinsException;

}
