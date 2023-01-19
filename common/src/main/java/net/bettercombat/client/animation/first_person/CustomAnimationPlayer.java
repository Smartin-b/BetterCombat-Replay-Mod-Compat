package net.bettercombat.client.animation.first_person;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;

public class CustomAnimationPlayer extends KeyframeAnimationPlayer implements IExtendedAnimation {

    /**
     * @param emote emote to play
     * @param t     begin playing from tick
     */
    public CustomAnimationPlayer(KeyframeAnimation emote, int t) {
        super(emote, t);
    }

    public boolean isWindingDown() {
        var windDownStart = getData().endTick + ((getData().stopTick - getData().endTick) / 4);
        return ((getTick() + 1) > windDownStart); // + 1 for smoother transition
    }

    @Override
    public boolean isActiveInFirstPerson() {
        return isActive() && !isWindingDown();
    }
}
