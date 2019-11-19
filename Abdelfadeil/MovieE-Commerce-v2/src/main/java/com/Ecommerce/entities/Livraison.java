package com.Ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


public enum  Livraison   {
    GRATUIT,
    DOMICILE,
    RELAIS,
    EXPRESS,
    BUREAU_POSTE

}
