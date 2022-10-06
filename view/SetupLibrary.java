package view;

import controler.SetupController;

public class SetupLibrary {

	private SetupController setupController;

	SetupLibrary() {
		setupController = new SetupController();

	}

	public void init() {

		boolean isSetupCompleted = setupController.isSetuped();
		if(isSetupCompleted) {
			System.out.println("Library setup already completed");
		}else {
			System.out.println("Library has to be setuped");
		}
	}
}
