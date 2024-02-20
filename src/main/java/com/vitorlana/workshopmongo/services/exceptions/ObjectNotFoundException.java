package com.vitorlana.workshopmongo.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID =  1L;

    //Sobrepor
    public ObjectNotFoundException (String msg){
        super(msg); // passando a mensagem para a super classe RuntimeException.
    }

}
