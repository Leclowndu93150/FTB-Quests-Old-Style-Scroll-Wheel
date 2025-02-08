package com.leclowndu93150.ftb_quests_old_style_scroll_wheel.mixin;

import dev.ftb.mods.ftbquests.client.gui.quests.QuestScreen;
import dev.ftb.mods.ftbquests.quest.Chapter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(QuestScreen.class)
public interface QuestScreenAccessor {
    @Accessor("selectedChapter")
    Chapter getSelectedChapter();
}
