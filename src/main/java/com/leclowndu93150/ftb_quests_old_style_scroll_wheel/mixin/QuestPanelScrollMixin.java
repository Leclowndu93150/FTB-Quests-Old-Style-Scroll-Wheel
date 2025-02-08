package com.leclowndu93150.ftb_quests_old_style_scroll_wheel.mixin;

import dev.ftb.mods.ftbquests.client.gui.quests.QuestPanel;
import dev.ftb.mods.ftbquests.client.gui.quests.QuestScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(QuestPanel.class)
public class QuestPanelScrollMixin {
    @Shadow
    private final QuestScreen questScreen;

    private QuestPanelScrollMixin() {
        this.questScreen = null;
    }

    /**
     * @author Leclowndu93150
     * @reason I don't know why they changed it, but it's really terrible.
     */
    @Overwrite
    public boolean scrollPanel(double scroll) {
        QuestPanel self = (QuestPanel)(Object)this;
        QuestScreenAccessor accessor = (QuestScreenAccessor) this.questScreen;

        if (accessor.getSelectedChapter() != null && !this.questScreen.isViewingQuest() && self.isMouseOver()) {
            this.questScreen.addZoom(scroll);
            return true;
        }

        return false;
    }
}