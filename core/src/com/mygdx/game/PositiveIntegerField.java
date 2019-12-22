package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class PositiveIntegerField extends TextField { // a text field that only allows positive integer numbers

    public PositiveIntegerField(String text, Skin skin) {

        super(text, skin);

        setTextFieldFilter(new TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                if (c=='0' || c=='1' || c=='2'|| c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8'|| c=='9' ){
                    return true;

                }



                return false;
            }
        });
    }

    public int getInteger(){
        if(getText().equalsIgnoreCase("")){
            return 0;

        }


        return Integer.valueOf(getText());

    }

    public void setText(int text){

        setText(Integer.toString(text));
    }

}
