This repository contains the source code for bennugd-monolithic.

The source code for this project used to be hosted in Google Code (https://code.google.com/archive/p/bennugd-monolithic/) and has been updated to use SDL-2.0.5, SDL2_mixer-2.0.1 & libpng-1.6.23, so that projects created with it are still uploadable to Google Play.

## To build:

### Prequisties: (Must be built and used in a 32bit environment)
tre-agrep \
libtre5 \
libtre-dev \
libpng-dev \
libvorbis-dev \
libogg-dev \
zlib1g-dev \

In Ubuntu 16.04 or newer, install with `sudo apt -y install tre-agrep libtre5 libtre-dev libpng-dev libvorbis-dev libogg-dev zlib1g-dev`

then \
`git clone https://github.com/christianhaitian/bennugd-monolithic.git` \
`cd bennugd-monolithic` \
`./build.sh`

Grab the bgdi executable and use it to launch the bennugd game. \
ex. ./bgdi SorR.dat

You can clean the directory by doing `./build.sh clean`
