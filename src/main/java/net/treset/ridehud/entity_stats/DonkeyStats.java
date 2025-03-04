package net.treset.ridehud.entity_stats;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.DonkeyEntity;

public class DonkeyStats extends VehicleStats {
    public DonkeyEntity donkey;
    
    public DonkeyStats(DonkeyEntity donkey) {
        this.uuid = donkey.getUuidAsString();
        this.entity = donkey;
        this.donkey = donkey;

        this.jumpHeightMin = 1.089;
        this.jumpHeightMax = 5.293;
        this.jumpModifier = donkey.getAttributeValue(EntityAttributes.GENERIC_JUMP_STRENGTH);
        this.jumpHeight = Math.pow(this.jumpModifier, 1.7) * 5.293;
        this.jumpScore = (int)((this.jumpHeight - this.jumpHeightMin) / (this.jumpHeightMax - this.jumpHeightMin) * 100);

        this.speedMin = 4.86;
        this.speedMax = 14.57;
        this.speedModifier = donkey.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        this.speed = this.speedModifier * 43.17;
        this.speedScore = (int)((this.speed - this.speedMin) / (this.speedMax - this.speedMin) * 100);

        this.healthMin = 15;
        this.healthMax = 30;
        this.health = (int)donkey.getMaxHealth();
        this.healthHearts = this.health / 2;
        this.healthScore = (int)((float)(this.health - this.healthMin) / (float)(healthMax - this.healthMin) * 100);

        this.healthCurrent = (int)donkey.getHealth();

        this.score = (this.jumpScore + this.speedScore + this.healthScore) / 3;
    }

    public void updateCurrentHealth() {
        this.healthCurrent = (int)this.donkey.getHealth();
    }
}
