package de.petropia.bauwelt.status;

import de.petropia.bauwelt.Bauwelt;
import eu.cloudnetservice.driver.channel.ChannelMessage;
import eu.cloudnetservice.driver.event.EventListener;
import eu.cloudnetservice.driver.event.events.channel.ChannelMessageReceiveEvent;
import eu.cloudnetservice.driver.network.buffer.DataBuf;

public class BuildworldStatusRequest {

    @EventListener
    public void onChannelMessage(ChannelMessageReceiveEvent event){
        if(!event.channel().equals("bauworld_status")){
            return;
        }
        if(!event.message().equals("world_status")){
            return;
        }
        if(!event.query()){
            return;
        }
        event.queryResponse(ChannelMessage.buildResponseFor(event.channelMessage())
                .buffer(DataBuf.empty().writeInt(Bauwelt.getPlots().size()))
                .build());
    }
}
