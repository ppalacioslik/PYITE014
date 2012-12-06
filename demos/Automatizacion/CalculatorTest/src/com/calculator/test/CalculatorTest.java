package com.calculator.test;

import junit.framework.Assert;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings("rawtypes")
public class CalculatorTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.calculator.CalculatorActivity";

    private static Class<?> launcherActivityClass;
    static{
            try {
                    launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
            } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
            }
    }
    
    @SuppressWarnings("unchecked")
	public CalculatorTest() throws ClassNotFoundException {
            super(launcherActivityClass);
    }
    
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	//Métodos de automatización
	//Nótese que los nombres de los métodos deben empezar con "test"
	public void testMultiplicar() {
		//Se ingresa el texto 5 en el primer campo de texto (EditText con index 0)
		solo.enterText(0, "5");
		//Se ingresa el texto 4 en el primer campo de texto (EditText con index 1)
		solo.enterText(1, "4");
		//Presionar el botón con texto x (multiplicar)
		solo.clickOnButton("x");
		//Verificar que la respuesta es correcta
		//Para ello se busca el texto 20 (5 x 4)
		Assert.assertTrue(solo.searchText("20"));
	}
	
	public void testDividirEntreCero() {
		solo.enterText(0, "5");
		solo.enterText(1, "0");
		solo.clickOnButton("÷");
		Assert.assertTrue(solo.waitForText("No se puede realizar una división entre cero."));
	}

}
