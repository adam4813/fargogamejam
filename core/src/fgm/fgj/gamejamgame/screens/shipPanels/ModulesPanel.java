package fgm.fgj.gamejamgame.screens.shipPanels;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import fgm.fgj.gamejamgame.AnimatedImage;
import fgm.fgj.gamejamgame.AnimatedSprite;
import fgm.fgj.gamejamgame.CargoBay;
import fgm.fgj.gamejamgame.Engine;
import fgm.fgj.gamejamgame.GameJamGame;
import fgm.fgj.gamejamgame.LifeSupportSystem;
import fgm.fgj.gamejamgame.Ship;
import fgm.fgj.gamejamgame.Weapon;

public class ModulesPanel {
	private Skin skin;

	public Table getRoot() {
		return root;
	}

	Table root = new Table();

	Table engineModuleTable = new Table();
	Table weaponModuleTable = new Table();
	Table cargoModuleTable = new Table();
	Table lifeSupportModuleTable = new Table();

	public ModulesPanel(Skin skin) {
		this.skin = skin;
		root.padRight(8).padTop(8);
		root.add(new Label("Equipped Modules", skin, "bg")).expandX().top().left();

		root.row();

		Table modulesTable = new Table();
		modulesTable.add(engineModuleTable).uniform();
		modulesTable.add(lifeSupportModuleTable).uniform();

		modulesTable.row();

		modulesTable.add(weaponModuleTable).uniform();
		modulesTable.add(cargoModuleTable).uniform();
		root.add(modulesTable).top().left().growY();
	}

	public void displayModules(GameJamGame game, Ship ship) {
		engineModuleTable.clearChildren();
		Engine engine = ship.getEngine();
		int engineLevel = engine.getEfficiency() + 1;
		Animation engineAnimation = AnimatedSprite.buildAnimation(game.getAsset("data/modules/moduleEngine0" + engineLevel + ".png"), 64, 64, 8, .1f);
		engineModuleTable.add(new AnimatedImage(engineAnimation)).uniform().expand();
		engineModuleTable.add(new Label(new StringBuilder().append("Engine: ").append(engineLevel).toString(), skin)).uniform().expand();

		lifeSupportModuleTable.clearChildren();
		LifeSupportSystem lifeSupportSystem = ship.getLifeSupport();
		//int engineLevel = engine.getEfficiency() + 1;
		Animation lifeSupportSystemAnimation = AnimatedSprite.buildAnimation(game.getAsset("data/modules/moduleLifeSupport0" + engineLevel + ".png"), 64, 64, 8, .1f);
		lifeSupportModuleTable.add(new AnimatedImage(lifeSupportSystemAnimation)).uniform().expand();
		lifeSupportModuleTable.add(new Label(new StringBuilder().append("Life Support: ").append(engineLevel).toString(), skin)).uniform().expand();

		weaponModuleTable.clearChildren();
		Weapon weapon = ship.getWeapon();
		//int engineLevel = engine.getEfficiency() + 1;
		Animation weaponAnimation = AnimatedSprite.buildAnimation(game.getAsset("data/modules/moduleWeapon0" + engineLevel + ".png"), 64, 64, 16, .1f);
		weaponModuleTable.add(new AnimatedImage(weaponAnimation)).uniform().expand();
		weaponModuleTable.add(new Label(new StringBuilder().append("Weapon: ").append(engineLevel).toString(), skin)).uniform().expand();

		cargoModuleTable.clearChildren();
		CargoBay cargoBay = ship.getCargoBay();
		//int engineLevel = engine.getEfficiency() + 1;
		Animation cargoBayAnimation = AnimatedSprite.buildAnimation(game.getAsset("data/modules/moduleCargo0" + engineLevel + ".png"), 64, 64, 5, .1f);
		cargoModuleTable.add(new AnimatedImage(cargoBayAnimation)).uniform().expand();
		cargoModuleTable.add(new Label(new StringBuilder().append("Cargo Bat: ").append(engineLevel).toString(), skin)).uniform().expand();
	}
}
