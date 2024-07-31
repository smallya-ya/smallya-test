<template>
  <div>
    <Chart :cdata="cdata" />
  </div>
</template>

<script>
import Chart from './chart.vue';
export default {
  data () {
    return {
      cdata: {
        xData: ["data1", "data2", "data3", "data4", "data5", "data6"],
        seriesData: [
          { value: 10, name: "评分A" },
          { value: 5, name: "评分E" },
          { value: 15, name: "评分S" },
          { value: 25, name: "评分C" },
          { value: 20, name: "评分D" },
          { value: 35, name: "评分B" }
        ]
      }
    }
  },
  components: {
    Chart,
  },
  mounted () {
  },
  methods: {
  }
}
</script>

<style lang="scss" scoped>
</style>
