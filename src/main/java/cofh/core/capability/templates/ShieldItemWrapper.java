package cofh.core.capability.templates;

import cofh.core.capability.CapabilityShieldItem;
import cofh.lib.api.capability.IShieldItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShieldItemWrapper implements IShieldItem, ICapabilityProvider {

    private final LazyOptional<IShieldItem> holder = LazyOptional.of(() -> this);

    final ItemStack shieldItem;

    public ShieldItemWrapper(ItemStack shieldItem) {

        this.shieldItem = shieldItem;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, final @Nullable Direction side) {

        return CapabilityShieldItem.SHIELD_ITEM_CAPABILITY.orEmpty(cap, this.holder);
    }

}
