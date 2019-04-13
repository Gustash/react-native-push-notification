/** @format */

import { AppRegistry } from "react-native";
import App from "./App";
import Bubble from "./Bubble";
import { name as appName } from "./app.json";

AppRegistry.registerComponent(appName, () => App);
AppRegistry.registerComponent("bubble", () => Bubble);
