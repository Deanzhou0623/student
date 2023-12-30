import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server:{
    port:80,
    host: "0.0.0.0",
    proxy:{
      '/api': {
        target:'http://localhost:9090',
        changeOrigin: true,
      }
    }
  }
})
