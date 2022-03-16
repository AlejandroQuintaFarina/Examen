import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public final class ExampleBot {

    public static void main(final String[] args) {

        final String token ="OTUzNjM2NDM1OTM4OTMwNzM5.YjHdJA.ZJuIfclGgb6T1cFRlOE-MhP2FII";//creacion del token
        final DiscordClient client = DiscordClient.create(token);//conexion del bot con discord
        final GatewayDiscordClient gateway = client.login().block();//conexion del bot con discord

        gateway.on(MessageCreateEvent.class).subscribe(event -> {//evento
            final Message message = event.getMessage();//creacion del mensaje del evento
            if ("!ping".equals(message.getContent())) {//condicion para el evento
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();//mensaje
            }
        });
        gateway.onDisconnect().block();//desconexion del bot del canal de voz
    }

}
