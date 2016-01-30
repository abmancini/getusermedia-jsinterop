package com.jooink.experiments.jsinterop.getusermedia.client;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

public class Wraps {

	//i do not like to have many classes in the same file but 
	//to keep the sample readable i think it is better to resist !!

	@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="navigator")
	final static class Navigator {
		public static native void webkitGetUserMedia( Configs configs, SuccessCallback success, ErrorCallback error);
	}

	//this would suffice but the call Utils.webkitGetUserMedia is less expressive than Navigator.webkitGetUserMedia
	//@JsMethod(namespace="navigator")
	//public static native void webkitGetUserMedia( Configs configs, SuccessCallback success, ErrorCallback error);

	// equivalent JSNI, allows for polifilling eventually
	// public static final native void getUserMedia( Configs configs, SuccessCallback success, ErrorCallback error) /*-{
	//        navigator.webkitGetUserMedia( configs, success, error );
	//}-*/;


	@JsType(namespace = JsPackage.GLOBAL, isNative = true)
	final static class URL {
		public static native String createObjectURL(MediaStream ms);	
	}


	@JsFunction
	public interface SuccessCallback  {
		public  void onMediaSuccess(MediaStream stream);
	}

	@JsFunction 
	public interface ErrorCallback {
		public void onError(DomException error);
	}

	@JsType(namespace = JsPackage.GLOBAL, isNative = true)
	public interface MediaStream {
		// eventual native methods we would like to expose, empty for the current example
	}


	@JsType(namespace = JsPackage.GLOBAL, isNative = true)
	public interface DomException  {
	}


	@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="Object")
	public static class Configs  {
		@JsProperty 
		public native void setVideo(boolean getVideo);

		@JsProperty 
		public native void setAudio(boolean getVideo);
	}



	@JsType(namespace = JsPackage.GLOBAL, isNative = true, name="console")
	final static class Console {
		public static native void log(Object ms);
	}

}
