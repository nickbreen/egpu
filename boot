#!/bin/bash

set -euo pipefail

ovmf=${ovmf:-/usr/share/OVMF}
vars=${vars:-$ovmf/OVMF_VARS.fd}
code=${code:-$ovmf/OVMF_CODE.fd}
tmp=${tmp:-$(mktemp)}
mem=${mem:-8192}
dev=${dev:?specify pci device}

trap "rm $tmp" EXIT

cp ${vars} ${tmp}
qemu-system-x86_64 \
-enable-kvm \
-m ${mem} \
-cpu host,kvm=off \
-vga none \
-device vfio-pci,host=${dev},multifunction=on \
-drive if=pflash,format=raw,readonly,file=${code} \
-drive if=pflash,format=raw,file=${tmp}

