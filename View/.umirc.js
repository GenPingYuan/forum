
import { resolve } from 'path';
var AUTOPREFIXER_BROWSERS = [
  'Android 2.3',
  'Android >= 4',
  'Chrome >= 35',
  'Firefox >= 31',
  'Explorer >= 9',
  'iOS >= 7',
  'Opera >= 12',
  'Safari >= 7.1',
]
// ref: https://umijs.org/config/
export default {
  plugins: [
    // ref: https://umijs.org/plugin/umi-plugin-react.html
    ['umi-plugin-react', {
      antd: true,
      dva: {
        immer: true
      },
      dynamicImport: true,
      title: 'View',
      dll: true,
      routes: {
        exclude: [],
      },
      hardSource: true
    }]
  ],
  proxy: {
    '/api/': {
      target: 'http://localhost:9002',
      changeOrigin: true,
      pathRewrite: { '^/api': '' },
    },
    '/static/': {
      target: 'http://localhost:9002',
      changeOrigin: true,
      pathRewrite: { '^/static': '' },
    }
  },
  alias: {
    api: resolve(__dirname, './src/services/'),
    components: resolve(__dirname, './src/components'),
    config: resolve(__dirname, './src/utils/config'),
    models: resolve(__dirname, './src/models'),
    routes: resolve(__dirname, './src/routes'),
    services: resolve(__dirname, './src/services'),
    themes: resolve(__dirname, './src/themes'),
    utils: resolve(__dirname, './src/utils'),
    resource: resolve(__dirname, './src/assets'),
  },

  chainWebpack(config, { webpack }) {
        config.module
        .rule('css')
          .test("/\.css$/")
          .use('css')
            .loader('css-loader')
              .options({
                importLoaders: 1
              })
            .loader('postcss-loader')
              .options({ident: 'postcss'})
            .loader('px2rem2-loader')
              .options({remUnit: 75, remPrecision: 8})
              .end()
          .test("/\.sass$/")
          .use("sass")
            .loader('style-loader')
            .loader('css-loader')
            .loader('sass-loader')
            .loader('px2rem2-loader')
              .options({remUnit: 75, remPrecision: 8})
              .end();
        
        // config.module.rule('css')
        // .test(/\.sass$/)
        // .use('style-loader')
        //   .loader('sass-loader');
  },
  // disableCSSModules: true,

  extraPostCSSPlugins: [
    require('postcss-import')(),
    // require('precss')(),
    require('autoprefixer')({
      browsers: AUTOPREFIXER_BROWSERS
    })
  ]
}
