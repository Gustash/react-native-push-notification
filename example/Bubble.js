import React from "react";
import { Text, ScrollView, Dimensions } from "react-native";

const Bubble = () => {
  const { height } = Dimensions.get("window");

  return (
    <ScrollView
      contentContainerStyle={{ alignItems: "center", justifyContent: "center" }}
    >
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
      <Text>I am a Bubble with a {height} height.</Text>
    </ScrollView>
  );
};

export default Bubble;
