package com.safetybus.pc.safetybus2.face;

import java.util.ArrayList;

import com.safetybus.pc.safetybus2.model.OnibusModel;

public interface OnibusInterface {
    public void CadastrarOnibus(OnibusModel onibus);
    public void RemoverOnibus(OnibusModel onibus);
    public ArrayList<OnibusModel> ConsutarOnibus(OnibusModel onibus);
}
