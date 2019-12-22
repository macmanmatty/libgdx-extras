package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

        public class PositiveFloatField extends TextField { // a text field that only allows positive  decimal numbers to be ntered

    public PositiveFloatField(String text, Skin skin) {

        super(text, skin);

        setTextFieldFilter(new TextFieldFilter() {
            @Override
            public boolean acceptChar(TextField textField, char c) {
                if (c=='0' || c=='1' || c=='2'|| c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8'|| c=='9' || c=='.'){
                    return true;

                }



                return false;
            }
        });
    }

            public float getFloat(){
                if(getText().equalsIgnoreCase("")){
                    return 0;

                }


            return Float.valueOf(getText());

        }

            public double getDouble(){
                if(getText().equalsIgnoreCase("")){
                    return 0;

                }

                return Double.valueOf(getText());

            }


            public void setText(double text){

                setText(Double.toString(text));
            }
            public void setText(float text){

                setText(Float.toString(text));
            }
        }
