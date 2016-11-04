
package com.jfixby.r3.parallax.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.FokkerLwjglApplication;
import com.badlogic.gdx.backends.lwjgl.FokkerLwjglApplicationConfiguration;
import com.jfixby.cmns.api.input.UserInput;
import com.jfixby.r3.fokker.api.FokkerEngineAssembler;
import com.jfixby.r3.fokker.api.UnitsMachineExecutor;
import com.jfixby.red.desktop.DesktopSetup;
import com.jfixby.red.engine.core.FokkerStarter;
import com.jfixby.red.engine.core.FokkerStarterConfig;
import com.jfixby.red.input.RedInput;
import com.jfixby.redtriplane.fokker.adaptor.GdxAdaptor;

public class RunParallaxDesktop {
	public static void main (final String[] arg) {

		setupBasicComponents();
		final FokkerStarterConfig config = FokkerStarter.newRedTriplaneConfig();

		final FokkerEngineAssembler engine_assembler = new ParallaxDesktopAssembler();
		config.setEngineAssembler(engine_assembler);

		final FokkerStarter triplane_starter = FokkerStarter.newRedTriplane(config);
		final UnitsMachineExecutor machine = triplane_starter.getUnitsMachineExecutor();

		final GdxAdaptor adaptor = new GdxAdaptor(machine);

		final FokkerLwjglApplicationConfiguration cfg = new FokkerLwjglApplicationConfiguration();
		cfg.title = "Test";
		cfg.useGL30 = false;
		cfg.width = 1024;
		cfg.height = 768;
// cfg.vSyncEnabled = false;
// cfg.r = 1;
// cfg.g = 1;
// cfg.b = 1;
// cfg.a = 1;
// cfg.overrideDensity = 10;
// cfg.foregroundFPS = 60;

		final ApplicationListener gdx_listener = adaptor.getGDXApplicationListener();

		// gdx_listener = new HttpRequestTest();
		// GdxEntryPoint point = new GdxEntryPoint();
		// new LwjglApplication(point, cfg);
		new FokkerLwjglApplication(gdx_listener, cfg);

	}

	private static void setupBasicComponents () {
		DesktopSetup.deploy();

// L.installComponent(new DesktopLogger());
// Collections.installComponent(new DesktopCollections());
// Err.installComponent(new RedError());
// Debug.installComponent(new RedDebug());
// JUtils.installComponent(new RedJUtils());
// FloatMath.installComponent(new DesktopFloatMath());
// TaskManager.installComponent(new RedTaskManager());
// Sys.installComponent(new DesktopSystem());
// SystemSettings.installComponent(new RedSystemSettings());
//
// IntegerMath.installComponent(new RedIntegerMath());
// Names.installComponent(new RedAssetsNamespace());
// IO.installComponent(new RedIO());
// Graphs.installComponent(new RedGraphs());
// SimpleTriangulator.installComponent(new GdxSimpleTriangulator());
// Angles.installComponent(new RedAngles());
//
		UserInput.installComponent(new RedInput());
//
// final RedGeometry geometry = new RedGeometry();
// Geometry.installComponent(geometry);
// Colors.installComponent(new RedColors());
// MathTools.installComponent(new RedMathTools());
// // --
// Json.installComponent(new RedJson());
// Base64.installComponent(new GdxBase64());
// MD5.installComponent(new RSADataSecurityIncMD5());
	}
}