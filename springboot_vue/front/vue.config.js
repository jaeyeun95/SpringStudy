const path = require("path");

// 통신을 위한 설정
module.exports = {
  // VUE Build 경로 설정
  outputDir: path.resolve(
    __dirname,
    "../backend/src/main/resources/static"
  ),

  devServer: {
    // proxy: {
    //   "/member": {
    //     target: "http://localhost:9999",
    //     ws: true,
    //     changeOrigin: true, // Cors 에러를 막기위한 옵션
    //   },
    // },

    proxy:{
      target:'http://localhost:9999',
      changeOrigin: true, // Cors 에러를 막기위한 옵션

    }
  },
  
};
 