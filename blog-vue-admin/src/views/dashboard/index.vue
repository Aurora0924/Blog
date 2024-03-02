<template>
  <div class="dashboard-container">
    <div class="dashboard-text">
      欢迎您!登录Augenstern-Zhou博客管理系统
    </div>
    <div class="background">
      <span id="time" class="time">
        今天是：<span class="date">{{ nowTime }}</span>
        <span class="hour" style="margin-left: 20px;">{{ time.hour }}</span>
        <a class="split">:</a>
        <span class="minitus">{{ time.minitus }}</span>
        <a class="split">:</a>
        <span class="seconds">{{ time.seconds }}</span>
      </span>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Dashboard',
  props: ['s'],
  data() {
    return {
      time: {
        hour: '',
        minitus: '',
        seconds: ''
      },
      nowTime: '',
      week: [
        '星期天',
        '星期一',
        '星期二',
        '星期三',
        '星期四',
        '星期五',
        '星期六'
      ]
    }
  },
  mounted() {
    this.dateTime()
  },
  methods: {
    dateTime() {
      this.timeFormate()
      setTimeout(() => {
        this.dateTime()
      }, 1000)
    },
    timeFormate() {
      const newtime = new Date()
      this.time.hour = this.getIncrease(newtime.getHours(), 2)
      this.time.minitus = this.getIncrease(newtime.getMinutes(), 2)
      this.time.seconds = this.getIncrease(newtime.getSeconds(), 2)
      this.nowTime =
            this.getIncrease(newtime.getFullYear(), 4) +
            '年' +
            this.getIncrease(newtime.getMonth() + 1, 2) +
            '月' +
            this.getIncrease(newtime.getDate(), 2) +
            '日' + ' ' +
            this.week[newtime.getDay()]
    },
    getIncrease(num, digit) {
      let increase = ''
      for (let i = 0; i < digit; i++) {
        increase += '0'
      }
      return (increase + num).slice(-digit)
    }
  },
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>
<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 40px;
    text-align: center;
    line-height: 46px;
  }
}
.txt-data .time{
      font-size: 1rem;
      margin-right: 0.5rem;
    }
    .split{
      animation: shark 1s step-end infinite;
      vertical-align: center;
      margin-right: 2px;
      margin-left: 2px;
    }
    @keyframes shark {
      0%,
    100%{
        opacity: 1;
      }
      50%{
        opacity: 0;
      }
    }
    .background{
      text-align: center;
      margin-top: 100px;
      font-size: 40px;
      /* background-image: linear-gradient(to right , #7A88FF, #7AFFAF); */
    }
</style>
