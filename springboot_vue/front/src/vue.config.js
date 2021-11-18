const path = require("path");

// 통신을 위한 설정
module.exports = {
  // VUE Build 경로 설정
  outputDir: path.resolve(
    __dirname,
    "../SGVA_INPSYT/src/main/resources/static"
  ),

  // 시작 페이지 설정
  devServer: {
    proxy: {
      "/auth": {
        target: "http://localhost:9999",
        ws: true,
        changeOrigin: true, // Cors 에러를 막기위한 옵션
      },
      "/adminAPI": {
        target: "http://localhost:9999",
        ws: true,
        changeOrigin: true, // Cors 에러를 막기위한 옵션
      },
      "/api": {
        target: "http://localhost:9999",
        ws: true,
        changeOrigin: true, // Cors 에러를 막기위한 옵션
      },
      "/rasa": {
        target: "http://localhost:9999",
        ws: true,
        changeOrigin: true, // Cors 에러를 막기위한 옵션
      },
      "/bert": {
        target: "http://localhost:9999",
        ws: true,
        changeOrigin: true, // Cors 에러를 막기위한 옵션
      },
    },
  },

  transpileDependencies: ["vuetify"],
};
