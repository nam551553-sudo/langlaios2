#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
if [ "$(uname)" != Darwin ]; then
  echo 'IPA requires macOS and Xcode. Windows can validate Java with -PwithIos :ios:compileJava.' >&2
  exit 1
fi
chmod +x gradlew
./gradlew -PwithIos :ios:createIPA "$@"
