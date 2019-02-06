# egpu
Scripts and notes for eGPU virtualisation under Linux

# Setup (Manual)

1. Find PCI ID's for VM with `lspci`, and `ls -l /dev/disk/by-path/` 

       0000:03:00.0 Network controller: Intel Corporation Wireless 8260 (rev 3a)
       0000:09:00.0 VGA compatible controller: Advanced Micro Devices, Inc. [AMD/ATI] Tahiti PRO [Radeon HD 7950/8950 OEM / R9 280]
       0000:09:00.1 Audio device: Advanced Micro Devices, Inc. [AMD/ATI] Tahiti HDMI Audio [Radeon HD 7870 XT / 7950/7970]
       0000:3e:00.0 Non-Volatile memory controller: Intel Corporation Device f1a5 (rev 03)
 
2. Create new VM using virt-manager:
   1. UEFI!
   2. Add PCI devices
3. Boot, install, setup.

# Tweaks

## [Hyper-V] enlightenments

    virt-xml $VMNAME --edit --features hyperv_relaxed=on,hyperv_vapic=on,hyperv_spinlocks=on,hyperv_spinlocks_retries=8191
    virt-xml $VMNAME --edit --clock hypervclock_present=yes 

# Rererences

1. https://bufferoverflow.io/gpu-passthrough/
2. https://blog.zerosector.io/2018/07/28/kvm-qemu-windows-10-gpu-passthrough/
3. https://wiki.archlinux.org/index.php/PCI_passthrough_via_OVMF#Using_identical_guest_and_host_GPUs
4. http://vfio.blogspot.com/2015/05/vfio-gpu-how-to-series-part-4-our-first.html

[Hyper-V]: https://blog.wikichoon.com/2014/07/enabling-hyper-v-enlightenments-with-kvm.html


https://www.techpowerup.com/vgabios/131115/sapphire-hd7950-3072-120926-2