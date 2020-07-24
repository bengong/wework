# BootCDN API

重要提示：
BootCDN API 的初衷是对 cdnjs API 的国内加速，两者的功能和数据是一致的。现在 cdnjs API 的访问速度不再是问题了，因此 不再建议使用此 BootCDN API，请直接使用 cdnjs API。

API
将以下 API 链接中的 .min 字样去掉之后，获取到的 JSON 格式的返回信息是经过良好格式化的，便于人眼查看。

所有开源库简要信息列表
https://api.bootcdn.cn/libraries.min.json
该列表是一个 json 数组（Array），数组中的每一个条目是由开源库的名称（name）、描述（description）、星标数（stars）组成的数组。

请在浏览器中打开链接直接查看实例。

所有开源库名称列表
https://api.bootcdn.cn/names.min.json
该列表是一个 json 数组（Array），包含了所有开源库的名称（name）。

请在浏览器中打开链接直接查看实例。

获取某个开源库的详细信息
https://api.bootcdn.cn/libraries/[name].min.json
通过此接口获取到的是开源库的 JSON 对象（Object）格式的详细信息，包括所有版本以及文件列表。[name] 是开源库的名称，可从[开源库简要信息列表]或[开源库名称列表]中获取。

其中，assets 属性是所有版本及对应文件的列表。

以 bootstrap 为例，请在浏览器中打开 https://api.bootcdn.cn/libraries/bootstrap.json 直接查看。

FAQ
通过 API 获取到的数据的更新频率？
BootCDN 所加速的所有开源库绝大部分同步自 cdnjs 仓库，我们一般是每天都同步一次，也就是每次同步的时候才会更新 API 中提供的信息。

为什么没有搜索接口？
截止到目前，所有开源库也就不到 4000 个，整体可搜索的数据量很少，而且基本上都是搜索开源库的名称，所以数据量就更少了，通过上面提供的 API 获取到所有开源库的信息之后自己实现一个即时搜索也不难。况且能够搜索的信息基本上都是英文的，可以通过 lunr.js 或者正则表达式自己实现搜索功能。

再者，由于我们的更新频率一般是一天，所以可以将获取到数据缓存在本地较长的时间，从而不受网络状况和 BootCDN API 服务器的影响，最大程度加快本地搜索速度。