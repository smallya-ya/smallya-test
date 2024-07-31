<template>
  <div id="center">
    <div class="up">
      <div
        class="bg-color-black item"
        v-for="item in titleItem"
        :key="item.title"
      >
        <p class="ml-3 colorBlue fw-b fs-xl">{{ item.title }}</p>
        <div>
          <dv-digital-flop
            class="dv-dig-flop ml-1 mt-2 pl-3"
            :config="item.number"
          />
        </div>
      </div>
    </div>
    <div class="down">
      <!-- 射击分数排行榜区域 -->
      <div class="ranking bg-color-black">
        <span>
          <icon name="chart-pie" class="text-icon"></icon>
        </span>
        <span class="fs-xl text mx-2 mb-1 pl-3">射击分数前十排行榜</span>
        <dv-scroll-ranking-board class="dv-scr-rank-board mt-1" :config="ranking" />
      </div>
      <!-- 通过率和达标率展示区域 -->
      <div class="percent">
        <div class="item bg-color-black">
          <span>今日射击通过率</span>
          <CenterChart
            :id="rate[0].id"
            :tips="rate[0].tips"
            :colorObj="rate[0].colorData"
          />
        </div>
        <div class="item bg-color-black">
          <span>今日任务达标率</span>
          <CenterChart
            :id="rate[1].id"
            :tips="rate[1].tips"
            :colorObj="rate[1].colorData"
          />
        </div>
        <!-- 水位图展示区域 -->
        <div class="water">
          <dv-water-level-pond class="dv-wa-le-po" :config="water" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CenterChart from '@/components/bigscreen/echart/center/centerChartRate/index.vue'
import axios from 'axios';
/**
 * 大屏幕主组件
 * 展示射击分数排行榜、通过率和达标率
 */
export default {
  data() {
    return {
      // 演习相关统计数据
      titleItem: [
        {
          title: '今年演习次数',
          number: {
            number: [120],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        },
        {
          title: '本月演习次数',
          number: {
            number: [18],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        },
        {
          title: '今日演习次数',
          number: {
            number: [2],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        },
        {
          title: '今年失败任务次数',
          number: {
            number: [14],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        },
        {
          title: '今年成功任务次数',
          number: {
            number: [106],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        },
        {
          title: '今年达标任务个数',
          number: {
            number: [100],
            toFixed: 1,
            textAlign: 'left',
            content: '{nt}',
            style: {
              fontSize: 26
            }
          }
        }
      ],
      // 射击分数排行榜数据
      // ranking: {
      //   data: [
      //     {
      //       name: '张三',
      //       value: 50
      //     },
      //     {
      //       name: '李四',
      //       value: 43
      //     },
      //     {
      //       name: '王五',
      //       value: 33
      //     },
      //     {
      //       name: '老六',
      //       value: 46
      //     },
      //     {
      //       name: '老王',
      //       value: 10
      //     },
      //     {
      //       name: '小黑子',
      //       value: 49
      //     },
      //     {
      //       name: '蒸虾头',
      //       value: 35
      //     },
      //     {
      //       name: '香精煎鱼',
      //       value: 43
      //     },
      //     {
      //       name: '邮电部诗人',
      //       value: 8
      //     },
      //     {
      //       name: '万泉部诗人',
      //       value: 2
      //     },
      //
      //   ],
      //   carousel: 'single',
      //   unit: '分'
      // },
      ranking: {
        data: [],
        carousel: 'single',
        unit: '分'
      },
      // 水位图数据
      water: {
        data: [20, 45],
        shape: 'roundRect',
        formatter: '{value}%',
        waveNum: 3
      },
      // 通过率和达标率数据
      // 通过率和达标率的组件复用数据
      rate: [
        {
          id: 'centerRate1',
          tips: 50,
          colorData: {
            textStyle: '#3fc0fb',
            series: {
              color: ['#00bcd44a', 'transparent'],
              dataColor: {
                normal: '#03a9f4',
                shadowColor: '#97e2f5'
              }
            }
          }
        },
        {
          id: 'centerRate2',
          tips: 30,
          colorData: {
            textStyle: '#67e0e3',
            series: {
              color: ['#faf3a378', 'transparent'],
              dataColor: {
                normal: '#ff9800',
                shadowColor: '#fcebad'
              }
            }
          }
        }
      ]
    }
  },
  methods: {
    async fetchData() {
      try {
        const responseRanking = await axios.get('/api/bigscreen/ranking');
        this.ranking.data = responseRanking.data;
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    }
    },
  components: {
    CenterChart
  }
}
</script>

<style lang="scss" scoped>
#center {
  display: flex;
  flex-direction: column;
  .up {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    .item {
      border-radius: 6px;
      padding-top: 8px;
      margin-top: 8px;
      width: 32%;
      height: 70px;
      .dv-dig-flop {
        width: 150px;
        height: 30px;
      }
    }
  }
  .down {
    padding: 6px 4px;
    padding-bottom: 0;
    width: 100%;
    display: flex;
    height: 255px;
    justify-content: space-between;
    .bg-color-black {
      border-radius: 5px;
    }
    .ranking {
      padding: 10px;
      width: 59%;
      .dv-scr-rank-board {
        height: 225px;
      }
    }
    .percent {
      width: 40%;
      display: flex;
      flex-wrap: wrap;
      .item {
        width: 50%;
        height: 120px;
        span {
          margin-top: 8px;
          font-size: 14px;
          display: flex;
          justify-content: center;
        }
      }
      .water {
        width: 100%;
        .dv-wa-le-po {
          height: 120px;
        }
      }
    }
  }
}
</style>
<style lang="scss" scoped>
@import '@/assets/bigscreen/scss/style';
</style>
