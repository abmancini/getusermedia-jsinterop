package com.jooink.experiments.jsinterop.getusermedia.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.jooink.experiments.jsinterop.getusermedia.client.Wraps.Configs;
import com.jooink.experiments.jsinterop.getusermedia.client.Wraps.Console;
import com.jooink.experiments.jsinterop.getusermedia.client.Wraps.Navigator;
import com.jooink.experiments.jsinterop.getusermedia.client.Wraps.URL;

public class Getusermedia_jsinterop_sample implements EntryPoint {

	@Override
	public void onModuleLoad() {


		Video video = Video.createIfSupported();
		RootPanel.get().add(video);
		video.play();

		Configs configs = new Configs();
		configs.setVideo(true);
		//configs.setAudio(true);


		Navigator.webkitGetUserMedia(configs, 
				stream -> video.setSrc( URL.createObjectURL(stream) ) ,
				e -> { 
					Window.alert("Error: " + e);
					Console.log(e); 
				});
	}

}
