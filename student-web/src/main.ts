// main.ts
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/dark/css-vars.css'
import './assets/global.css'
import App from './components/Index.vue'

const app = createApp(App)

app.use(ElementPlus)
app.mount('#app')
