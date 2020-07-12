const express = require("express");
const app = express(); // 请求server
var appData = require("./public/mock.json");
var seller = appData;
var apiRoutes = express.Router();
app.use("api/seller", apiRoutes); //通过路由请求数据

module.exports = {
  // 选项

  //  基本路径

  publicPath:
    process.env.NODE_ENV === "production"
      ? "./" //生产环境，路径为网站的子路径
      : "/", //开发环境下//  构建时的输出目录

  outputDir: "dist", //  放置静态资源的目录

  assetsDir: "static", //  html 的输出路径

  indexPath: "index.html", //文件名哈希

  filenameHashing: true, //用于多页配置，默认是 undefined

  pages: {
    index: {
      // page 的入口文件

      entry: "src/index/main.js", // 模板文件

      template: "public/index.html", // 在 dist/index.html 的输出文件

      filename: "index.html", // 当使用页面 title 选项时， // template 中的 title 标签需要是 <title><%= htmlWebpackPlugin.options.title %></title>

      title: "Index Page", // 在这个页面中包含的块，默认情况下会包含 // 提取出来的通用 chunk 和 vendor chunk。

      chunks: ["chunk-vendors", "chunk-common", "index"],
    }, // 当使用只有入口的字符串格式时， // 模板文件默认是 `public/subpage.html` // 如果不存在，就回退到 `public/index.html`。 // 输出文件默认是 `subpage.html`。

    subpage: "src/subpage/main.js",
  }, //  是否在保存的时候使用 `eslint-loader` 进行检查。

  lintOnSave: true, //  是否使用带有浏览器内编译器的完整构建版本

  runtimeCompiler: false, //  babel-loader 默认会跳过 node_modules 依赖。

  transpileDependencies: [
    /* string or regex */
  ], //  是否为生产环境构建生成 source map？

  productionSourceMap: true, //  设置生成的 HTML 中 <link rel="stylesheet"> 和 <script> 标签的 crossorigin 属性。

  crossorigin: "", //  在生成的 HTML 中的 <link rel="stylesheet"> 和 <script> 标签上启用 Subresource Integrity (SRI)。

  integrity: false, //  调整内部的 webpack 配置

  configureWebpack: () => {}, //(Object | Function)

  chainWebpack: () => {}, // 配置 webpack-dev-server 行为。

  devServer: {
    // 这是跨域配置c
    open: process.platform === "darwin",

    host: "localhost",

    port: 8080,

    https: false,

    hotOnly: false, // 查阅 https://github.com/vuejs/vue-docs-zh-cn/blob/master/vue-cli/cli-service.md#配置代理

    proxy: {
      "/api": {
        target: "http://192.168.0.102:8080/",

        changeOrigin: true,

        secure: false,

        pathRewrite: {
          "^/api": "",
        },
      },

      "/foo": {
        target: "<other_url>",
      },
      // "/product": {
      //   target: "http://192.168.0.102:8080", // 域名 这会告诉开发服务器将任何未知请求 (没有匹配到静态文件的请求) 代理到http://localhost:8080
      //   changOrigin: true, // 开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
      //   pathRewrite: {
      //     "^/product": "", // // 替换target中的请求地址，也就是说，在请求的时候，url用'/proxy'代替'http://ip.taobao.com'
      //   },
      // },
    }, // string | Object

    before: (app) => {
      // 配置获取本地JSON
      app.get("api/seller", (req, res, next) => {
        res.json({
          // 这里是你的json内容
          errno: 0,
          data: seller,
        });
      });
    },
  }, // CSS 相关选项

  css: {
    // 将组件内的 CSS 提取到一个单独的 CSS 文件 (只用在生产环境中)

    // 也可以是一个传递给 `extract-text-webpack-plugin` 的选项对象

    extract: true, // 是否开启 CSS source map？

    sourceMap: false, // 为预处理器的 loader 传递自定义选项。比如传递给 // Css-loader 时，使用 `{ Css: { ... } }`。

    loaderOptions: {
      css: {
        // 这里的选项会传递给 css-loader
      },

      postcss: {
        // 这里的选项会传递给 postcss-loader
      },
    }, // 为所有的 CSS 及其预处理文件开启 CSS Modules。 // 这个选项不会影响 `*.vue` 文件。

    modules: false,
  }, // 在生产环境下为 Babel 和 TypeScript 使用 `thread-loader` // 在多核机器下会默认开启。

  parallel: require("os").cpus().length > 1, // PWA 插件的选项。 // 查阅 https://github.com/vuejs/vue-docs-zh-cn/blob/master/vue-cli-plugin-pwa/README.md

  pwa: {}, // 三方插件的选项

  pluginOptions: {
    // ...
  },
};
